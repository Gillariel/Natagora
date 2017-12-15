<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * Bird Model
 *
 * @property \App\Model\Table\ObservationTable|\Cake\ORM\Association\BelongsToMany $Observation
 *
 * @method \App\Model\Entity\Bird get($primaryKey, $options = [])
 * @method \App\Model\Entity\Bird newEntity($data = null, array $options = [])
 * @method \App\Model\Entity\Bird[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\Bird|bool save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\Bird patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\Bird[] patchEntities($entities, array $data, array $options = [])
 * @method \App\Model\Entity\Bird findOrCreate($search, callable $callback = null, $options = [])
 */
class BirdTable extends Table
{

    /**
     * Initialize method
     *
     * @param array $config The configuration for the Table.
     * @return void
     */
    public function initialize(array $config)
    {
        parent::initialize($config);

        $this->setTable('bird');
        $this->setDisplayField('ID');
        $this->setPrimaryKey('ID');

        $this->belongsToMany('Observation', [
            'foreignKey' => 'bird_id',
            'targetForeignKey' => 'observation_id',
            'joinTable' => 'observation_bird'
        ]);
    }

    /**
     * Default validation rules.
     *
     * @param \Cake\Validation\Validator $validator Validator instance.
     * @return \Cake\Validation\Validator
     */
    public function validationDefault(Validator $validator)
    {
        $validator
            ->integer('ID')
            ->allowEmpty('ID', 'create');

        $validator
            ->scalar('Name')
            ->maxLength('Name', 60)
            ->requirePresence('Name', 'create')
            ->notEmpty('Name');

        $validator
            ->integer('Length')
            ->allowEmpty('Length');

        $validator
            ->integer('Weight')
            ->allowEmpty('Weight');

        $validator
            ->dateTime('Creation_Date')
            ->requirePresence('Creation_Date', 'create')
            ->notEmpty('Creation_Date');

        return $validator;
    }
}
