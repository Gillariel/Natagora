<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * Observation Model
 *
 * @property \App\Model\Table\BirdTable|\Cake\ORM\Association\BelongsToMany $Bird
 *
 * @method \App\Model\Entity\Observation get($primaryKey, $options = [])
 * @method \App\Model\Entity\Observation newEntity($data = null, array $options = [])
 * @method \App\Model\Entity\Observation[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\Observation|bool save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\Observation patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\Observation[] patchEntities($entities, array $data, array $options = [])
 * @method \App\Model\Entity\Observation findOrCreate($search, callable $callback = null, $options = [])
 */
class ObservationTable extends Table
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

        $this->setTable('observation');
        $this->setDisplayField('ID');
        $this->setPrimaryKey('ID');

        $this->belongsToMany('Bird', [
            'foreignKey' => 'observation_id',
            'targetForeignKey' => 'bird_id',
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
            ->dateTime('Date')
            ->requirePresence('Date', 'create')
            ->notEmpty('Date');

        $validator
            ->integer('Session_ID')
            ->requirePresence('Session_ID', 'create')
            ->notEmpty('Session_ID');

        return $validator;
    }
}
