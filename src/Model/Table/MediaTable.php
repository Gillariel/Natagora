<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * Media Model
 *
 * @method \App\Model\Entity\Media get($primaryKey, $options = [])
 * @method \App\Model\Entity\Media newEntity($data = null, array $options = [])
 * @method \App\Model\Entity\Media[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\Media|bool save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\Media patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\Media[] patchEntities($entities, array $data, array $options = [])
 * @method \App\Model\Entity\Media findOrCreate($search, callable $callback = null, $options = [])
 */
class MediaTable extends Table
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

        $this->setTable('media');
        $this->setDisplayField('ID');
        $this->setPrimaryKey('ID');
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
            ->maxLength('Name', 100)
            ->requirePresence('Name', 'create')
            ->notEmpty('Name');

        $validator
            ->scalar('Url')
            ->maxLength('Url', 500)
            ->allowEmpty('Url');

        $validator
            ->scalar('Text')
            ->maxLength('Text', 144)
            ->allowEmpty('Text');

        $validator
            ->requirePresence('Validated', 'create')
            ->notEmpty('Validated');

        $validator
            ->requirePresence('Deleted', 'create')
            ->notEmpty('Deleted');

        $validator
            ->requirePresence('Has_Been_Pended', 'create')
            ->notEmpty('Has_Been_Pended');

        $validator
            ->dateTime('Creation_Date')
            ->requirePresence('Creation_Date', 'create')
            ->notEmpty('Creation_Date');

        $validator
            ->integer('MediaType_ID')
            ->requirePresence('MediaType_ID', 'create')
            ->notEmpty('MediaType_ID')
            ->add('MediaType_ID', 'unique', ['rule' => 'validateUnique', 'provider' => 'table']);

        $validator
            ->integer('Observation_ID')
            ->requirePresence('Observation_ID', 'create')
            ->notEmpty('Observation_ID')
            ->add('Observation_ID', 'unique', ['rule' => 'validateUnique', 'provider' => 'table']);

        return $validator;
    }

    /**
     * Returns a rules checker object that will be used for validating
     * application integrity.
     *
     * @param \Cake\ORM\RulesChecker $rules The rules object to be modified.
     * @return \Cake\ORM\RulesChecker
     */
    public function buildRules(RulesChecker $rules)
    {
        $rules->add($rules->isUnique(['MediaType_ID']));
        $rules->add($rules->isUnique(['Observation_ID']));

        return $rules;
    }
}
