<?php
namespace App\Test\TestCase\Model\Table;

use App\Model\Table\NextSessionIdTable;
use Cake\ORM\TableRegistry;
use Cake\TestSuite\TestCase;

/**
 * App\Model\Table\NextSessionIdTable Test Case
 */
class NextSessionIdTableTest extends TestCase
{

    /**
     * Test subject
     *
     * @var \App\Model\Table\NextSessionIdTable
     */
    public $NextSessionId;

    /**
     * Fixtures
     *
     * @var array
     */
    public $fixtures = [
        'app.next_session_id'
    ];

    /**
     * setUp method
     *
     * @return void
     */
    public function setUp()
    {
        parent::setUp();
        $config = TableRegistry::exists('NextSessionId') ? [] : ['className' => NextSessionIdTable::class];
        $this->NextSessionId = TableRegistry::get('NextSessionId', $config);
    }

    /**
     * tearDown method
     *
     * @return void
     */
    public function tearDown()
    {
        unset($this->NextSessionId);

        parent::tearDown();
    }

    /**
     * Test initialize method
     *
     * @return void
     */
    public function testInitialize()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }

    /**
     * Test validationDefault method
     *
     * @return void
     */
    public function testValidationDefault()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }
}
